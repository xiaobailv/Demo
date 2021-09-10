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
    public void nullTest() {
        Album album = new Album();
        album.setId("222");
        album = albumDao.selectOne(album);
        System.out.println("album = " + album);
        if (null != album && album.getTitle().equals("2")) {
            System.out.println("执行逻辑");
        }
    }

    @Test
    public void selectBycount() {
        List<Album> albums = albumDao.selectBycount(1);
        for (Album album : albums) {
            System.out.println("album = " + album);
        }
        System.out.println("albums.size() = " + albums.size());
    }
}
