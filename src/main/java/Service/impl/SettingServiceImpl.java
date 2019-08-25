package Service.impl;

import Dao.impl.SettingDaoImpl;
import Entity.Setting;
import Service.SettingService;
import net.sf.json.JSONObject;

import java.util.List;

public class SettingServiceImpl implements SettingService {
    private SettingDaoImpl settingDao;

    public void setSettingDao(SettingDaoImpl settingDao) {
        this.settingDao = settingDao;
    }

    @Override
    public String getSetting() {
        List list = settingDao.getSetting();
        Setting setting = (Setting) list.get(0);
        JSONObject adminJson = JSONObject.fromObject(setting);
        return adminJson.toString();
    }

    @Override
    public boolean editSetting(Setting setting) {
        boolean isEditSetting = settingDao.editSetting(setting);
        return isEditSetting;
    }
}
