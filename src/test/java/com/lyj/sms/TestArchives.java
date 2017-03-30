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
 * Created by lunyujie on 2027/3/27.
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
        Archives archives = archivesService.getArchives(2L);
        Long l = 2L;
        Assert.assertEquals(l, archives.getId());
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
        archives.setUserId(4L);
        archives.setTeacher("赵老师");
        archives.setLevels(2);
        archives.setSchoolName("郑州十一中");
        archives.setComments("优秀");
        archives.setGrade("一年级");
        archives.setSchoolAddress("郑州二七区");
        archivesService.saveArchives(archives);
        Archives archives2 = archivesService.getArchives(10L);
        Assert.assertEquals("郑州十一中", archives2.getSchoolName());
    }

    /**
     * 测试更新档案.
     */
    @Test
    public void testUpdateArchives() {
        Archives archives = archivesService.getArchives(2L);
        archives.setSchoolAddress("北京海淀区");
        archivesService.saveArchives(archives);
        Archives archives2 = archivesService.getArchives(2L);
        Assert.assertEquals("北京海淀区", archives2.getSchoolAddress());
    }

    /**
     * 测试删除档案.
     */
    @Test
    public void testRemoveArchives() {
        archivesService.removeArchives(2L);
        Archives archives = archivesService.getArchives(2L);
        Assert.assertNull(archives);
    }

    /**
     * 根据用户id 获取档案信息.
     */
    @Test
    public void testGetArchivesListByUserId() {
        List<Archives> archivesList = archivesService.getArchivesList(2L);
        Assert.assertNotNull(archivesList);
    }

    /**
     * 测试档案数量.
     */
    @Test
    public void testGetArchivesCount() {
        long count = archivesService.getArchivesCount();
        Assert.assertNotNull(count);
    }
}
