package Controller;

import Entity.Setting;
import Service.impl.SettingServiceImpl;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class SettingAction {

    private String settingInfo = "";

    public String getSettingInfo() {
        return settingInfo;
    }

    private SettingServiceImpl settingServiceimpl;

    private Boolean isEditSetting = false;

    public Boolean getIsEditSetting() {
        return isEditSetting;
    }

    public void setSettingServiceimpl(SettingServiceImpl settingServiceimpl) {
        this.settingServiceimpl = settingServiceimpl;
    }

    public String getSetting() {
        settingInfo = settingServiceimpl.getSetting();
        return "getSetting";
    }

    public String editSetting() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String settingJson = request.getParameter("setting");
        JSONObject jsonObject = JSONObject.fromObject(settingJson);
        Setting setting = (Setting) JSONObject.toBean(jsonObject, Setting.class);
        setting.setId(1);
        isEditSetting = settingServiceimpl.editSetting(setting);
        return "editSetting";
    }

}
