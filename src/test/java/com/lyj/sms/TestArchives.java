package com.lyj.sms;

import com.lyj.sms.bean.Archives;
import com.lyj.sms.config.javaConfig.AppConfig;
import com.lyj.sms.service.ArchivesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试档案.
 * Created by lunhengle on 2017/3/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@ActiveProfiles("test")
public class TestArchives {
    /**
     * 注入档案.
     */
    @Resource
    private ArchivesService archivesService;

    /**
     * 测试得到档案.
     */
    @Test
    public void testGetArchives() {
        Archives archives = archivesService.getArchives(1l);
        Assert.assertEquals(1l, archives.getId());
    }

    /**
     * 测试得到档案列表.
     */
    @Test
    public void testGetArchivesList() {
        List<Archives> archivesList = archivesService.getArchivesList("");
        Assert.assertEquals(9, archivesList.size());
        archivesList = archivesService.getArchivesList("外国");
        Assert.assertEquals(3, archivesList.size());
    }

    /**
     * 测试保存档案.
     */
    @Test
    public void testSaveArchives() {
        Archives archives = new Archives();
        archives.setUserId(4);
        archives.setTeacher("赵老师");
        archives.setLevels(1);
        archives.setSchoolName("郑州十一中");
        archives.setComments("优秀");
        archives.setGrade("一年级");
        archives.setSchoolAddress("郑州二七区");
        archivesService.saveArchives(archives);
        Archives archives1 = archivesService.getArchives(10l);
        Assert.assertEquals("郑州十一中", archives1.getSchoolName());
    }

    /**
     * 测试更新档案.
     */
    @Test
    public void testUpdateArchives() {
        Archives archives = archivesService.getArchives(1l);
        archives.setSchoolAddress("北京海淀区");
        archivesService.saveArchives(archives);
        Archives archives1 = archivesService.getArchives(1l);
        Assert.assertEquals("北京海淀区", archives1.getSchoolAddress());
    }

    /**
     * 测试删除档案.
     */
    @Test
    public void testRemoveArchives() {
        archivesService.removeArchives(1l);
        Archives archives = archivesService.getArchives(1l);
        Assert.assertNull(archives);
    }
}
