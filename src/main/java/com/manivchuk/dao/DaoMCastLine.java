package com.manivchuk.dao;

import com.manivchuk.beans.LineConfig;

import java.util.List;

/**
 * Created by Lenovo on 14.03.2017.
 */
public interface DaoMCastLine {
    void createLineConfig(LineConfig line);
    List<LineConfig> getAllLineConfig();
    LineConfig getLineConfigByHostname(String hostname);
    boolean updateLineConfig(LineConfig line);
    boolean deleteLineConfig(LineConfig line);
}
