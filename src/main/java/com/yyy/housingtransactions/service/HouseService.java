package com.yyy.housingtransactions.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyy.housingtransactions.dao.HouseMapper;
import com.yyy.housingtransactions.dao.UserMapper;
import com.yyy.housingtransactions.dao.WatchMapper;
import com.yyy.housingtransactions.model.House;
import com.yyy.housingtransactions.model.User;
import com.yyy.housingtransactions.model.Watch;
import com.yyy.housingtransactions.model.vo.HouseDetailVo;
import com.yyy.housingtransactions.model.vo.HouseQueryVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {

    @Resource
    private HouseMapper houseMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private WatchMapper watchMapper;

    public int insert(House house) {
        return houseMapper.insert(house);
    }

    public PageInfo<House> getAll(int pageNum,String content) {
        PageHelper.startPage(pageNum, 10);
        List<House> list = houseMapper.getAll(content);
        PageInfo<House> housePageInfo = new PageInfo<>(list);
        return housePageInfo;
    }

    public PageInfo<House> query(HouseQueryVo houseQueryVo) {
        if (StringUtils.isNotBlank(houseQueryVo.getPriceStr())) {
            houseQueryVo.setBeginPrice(new BigDecimal(houseQueryVo.getPriceStr().split(",")[0]));
            houseQueryVo.setEndPrice(new BigDecimal(houseQueryVo.getPriceStr().split(",")[1]));
        }
        if (StringUtils.isNotBlank(houseQueryVo.getSizeStr())) {
            houseQueryVo.setBeginSize(new BigDecimal(houseQueryVo.getSizeStr().split(",")[0]));
            houseQueryVo.setEndSize(new BigDecimal(houseQueryVo.getSizeStr().split(",")[1]));
        }
        PageHelper.startPage(houseQueryVo.getPageNum(), 5);
        List<House> list = houseMapper.query(houseQueryVo);
        PageInfo<House> housePageInfo = new PageInfo<>(list);
        return housePageInfo;
    }

    public HouseDetailVo selById(Long id) {
        House house = houseMapper.selectByPrimaryKey(id);
        User user = userMapper.selectByPrimaryKey(house.getUserId());
        HouseDetailVo detailVo = new HouseDetailVo();
        detailVo.setHouse(house);
        detailVo.setUser(user);
        return detailVo;
    }

    public List<House> selByUserId(Long userId) {
        return houseMapper.selByUserId(userId);
    }

    public void watch(Long userId, Long houseId) {
        Watch watch = watchMapper.selByUserIdAndHouseId(userId, houseId);
        if (watch == null) {
            watch = new Watch();
            watch.setUserId(userId);
            watch.setHouseId(houseId);
            watchMapper.insert(watch);
        }
    }

    public boolean isWatch(Long userId, Long houseId) {
        return watchMapper.selByUserIdAndHouseId(userId, houseId) != null;
    }

    public int unwatch(Long userId, Long houseId) {
        return watchMapper.delByUserIdAndHouseId(userId, houseId);
    }

    public List<House> selWatch(Long userId) {
        List<Watch> watches = watchMapper.selByUserId(userId);
        List<House> list = new ArrayList<>();
        for (Watch watch : watches) {
            House house = houseMapper.selectByPrimaryKey(watch.getHouseId());
            if (house != null) {
                list.add(house);
            }
        }
        return list;
    }

    public int del(Long houseId){
        return houseMapper.deleteByPrimaryKey(houseId);
    }
}
