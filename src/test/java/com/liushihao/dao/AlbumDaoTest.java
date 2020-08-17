package com.liushihao.dao;

import com.liushihao.entity.Album;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AlbumDaoTest {

    @Autowired
    private AlbumDao albumDao;

    @Test
    public void selectBycount() {
        List<Album> albums = albumDao.selectBycount(0);
        for (Album album : albums) {
            System.out.println("album = " + album);
        }
        System.out.println("albums.size() = " + albums.size());
    }
}
