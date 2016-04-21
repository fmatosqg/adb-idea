package com.developerphil.adbidea.action;

import com.developerphil.adbidea.adb.AdbFacade;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;

public class BackupData extends AdbAction {

    public void actionPerformed(AnActionEvent e, Project project) {
        AdbFacade.backupData(project);
    }
}
