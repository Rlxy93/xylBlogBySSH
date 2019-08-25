package Dao;

import Entity.Setting;

import java.util.List;

public interface SettingDao {
    List getSetting();
    boolean editSetting(Setting setting);
}
