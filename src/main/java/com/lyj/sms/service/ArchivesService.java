package com.lyj.sms.service;

import com.lyj.sms.bean.Archives;

import java.util.List;

/**
 * 档案service.
 * Created by lunyujie on 2017/3/23.
 */
public interface ArchivesService {
    /**
     * 根据id 得到档案.
     *
     * @param id 档案id
     * @return 档案
     */
    Archives getArchives(final Long id);

    /**
     * 保存档案.
     *
     * @param archives 档案
     */
    void saveArchives(final Archives archives);

    /**
     * 根据id删除档案.
     *
     * @param id id
     */
    void removeArchives(final Long id);

    /**
     * 根据学校名获取档案.
     *
     * @param schoolName 学校名
     * @return 档案列表
     */
    List<Archives> getArchivesList(final String schoolName);
    /**
     * 根据用户ID 获取档案信息.
     *
     * @param userId 用户ID
     * @return 用户档案信息
     */
    List<Archives> getArchivesList(final Long userId);
}
