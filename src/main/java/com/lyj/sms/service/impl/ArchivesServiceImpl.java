package com.lyj.sms.service.impl;

import com.lyj.sms.bean.Archives;
import com.lyj.sms.dao.ArchivesDao;
import com.lyj.sms.service.ArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 档案service.
 * Created by lunyujie on 2017/3/23.
 */
@Service
public class ArchivesServiceImpl implements ArchivesService {
    /**
     * 注入档案dao.
     */
    @Autowired
    private ArchivesDao archivesDao;

    /**
     * 根据id 得到档案.
     *
     * @param id 档案id
     * @return 档案
     */
    @Override
    public Archives getArchives(Long id) {
        return archivesDao.getArchives(id);
    }

    /**
     * 保存档案.
     *
     * @param archives 档案
     */
    @Override
    public void saveArchives(Archives archives) {
        archivesDao.saveArchives(archives);
    }

    /**
     * 根据id删除档案.
     *
     * @param id id
     */
    @Override
    public void removeArchives(Long id) {
        archivesDao.removeArchives(id);
    }

    /**
     * 根据档案名或者手机号获取档案.
     *
     * @param name 学校名
     * @return 档案列表
     */
    @Override
    public List<Archives> getArchivesList(String name) {
        return archivesDao.getArchivesList(name);
    }

    /**
     * 根据用户ID 获取档案信息.
     *
     * @param userId 用户ID
     * @return 用户档案信息
     */
    @Override
    public List<Archives> getArchivesList(Long userId) {
        return archivesDao.getArchivesList(userId);
    }

    /**
     * 获取档案个数.
     *
     * @return 档案个数
     */
    @Override
    public Long getArchivesCount() {
        return archivesDao.getArchivesCount();
    }
}
