package Lhy.webpackage.service.interfaces;

import Lhy.webpackage.bean.TCItem;

import java.util.List;

/**
 * Created by lhy on 2018/6/25.
 */
public interface ItemService {
    List<TCItem> findAll();
    TCItem findByName(String name);
}
