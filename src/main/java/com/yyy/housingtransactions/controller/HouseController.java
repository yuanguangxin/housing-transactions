package com.yyy.housingtransactions.controller;

import com.yyy.housingtransactions.model.House;
import com.yyy.housingtransactions.model.common.CommonObjectResponse;
import com.yyy.housingtransactions.model.vo.HouseQueryVo;
import com.yyy.housingtransactions.model.vo.HouseVo;
import com.yyy.housingtransactions.service.HouseService;
import com.yyy.housingtransactions.util.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/rest/house")
public class HouseController {

    @Resource
    private HouseService houseService;

    @PostMapping("/post")
    public CommonObjectResponse post(HouseVo houseVo) throws Exception {
        if (StringUtils.isBlank(houseVo.getTitle())
                || StringUtils.isBlank(houseVo.getTitle())
                || StringUtils.isBlank(houseVo.getIntro())
                || houseVo.getSize() == null
                || houseVo.getPrice() == null
                || StringUtils.isBlank(houseVo.getLayout())
                || StringUtils.isBlank(houseVo.getTowards())
                || StringUtils.isBlank(houseVo.getEstate())
                || StringUtils.isBlank(houseVo.getFloor())
                || StringUtils.isBlank(houseVo.getDetail())) {
            return CommonObjectResponse.notOk("信息填写不完整");
        }

        if (houseVo.getFiles().size() == 0) {
            return CommonObjectResponse.notOk("请上传预览图片");
        }
        String imgs = "";
        for (MultipartFile file : houseVo.getFiles()) {
            if (!FileUtil.isPic(file.getOriginalFilename())) {
                return CommonObjectResponse.notOk("图片格式错误");
            }
            if (file.getSize() >= 4 * 1024 * 1024) {
                return CommonObjectResponse.notOk("图片大小超出最大限制");
            }
            String key = FileUtil.upload("house" + System.currentTimeMillis(), file.getInputStream());
            imgs = imgs.concat(key + ";");
        }
        houseVo.setCreateTime(new Date());
        houseVo.setImgs(imgs);
        houseService.insert(houseVo);
        return CommonObjectResponse.ok();
    }


    @PostMapping("/query")
    public CommonObjectResponse query(@RequestBody HouseQueryVo houseQueryVo) {
        return CommonObjectResponse.ok(houseService.query(houseQueryVo));
    }

    @GetMapping("/detail")
    public CommonObjectResponse detail(@RequestParam("id") Long id) {
        return CommonObjectResponse.ok(houseService.selById(id));
    }

    @GetMapping("/watch")
    public CommonObjectResponse watch(@RequestParam("userId") Long userId, @RequestParam("houseId") Long houseId) {
        houseService.watch(userId, houseId);
        return CommonObjectResponse.ok();
    }

    @GetMapping("/unwatch")
    public CommonObjectResponse unwatch(@RequestParam("userId") Long userId, @RequestParam("houseId") Long houseId) {
        houseService.unwatch(userId, houseId);
        return CommonObjectResponse.ok();
    }

    @GetMapping("/isWatch")
    public CommonObjectResponse isWatch(@RequestParam("userId") Long userId, @RequestParam("houseId") Long houseId) {
        return CommonObjectResponse.ok(houseService.isWatch(userId, houseId));
    }

    @GetMapping("/selPost")
    public CommonObjectResponse selPost(@RequestParam("userId") Long userId) {
        return CommonObjectResponse.ok(houseService.selByUserId(userId));
    }

    @GetMapping("/selWatch")
    public CommonObjectResponse selWatch(@RequestParam("userId") Long userId) {
        return CommonObjectResponse.ok(houseService.selWatch(userId));
    }

    @GetMapping("/del")
    public CommonObjectResponse del(@RequestParam("houseId")Long houseId){
        houseService.del(houseId);
        return CommonObjectResponse.ok();
    }
}
