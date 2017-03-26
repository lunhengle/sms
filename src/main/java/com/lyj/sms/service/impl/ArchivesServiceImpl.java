package com.lyj.sms.service.impl;

import com.lyj.sms.dao.ArchivesDao;
import com.lyj.sms.service.ArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 档案service.
 * Created by lunyujie on 2017/3/23.
 */
@Service
public class ArchivesServiceImpl implements ArchivesService {
    @Autowired
    private ArchivesDao archivesDao;
}
