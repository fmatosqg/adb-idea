package com.developerphil.adbidea.action;

import com.intellij.icons.AllIcons;
import com.intellij.ide.actions.QuickSwitchSchemeAction;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.ListPopup;
import com.intellij.util.ui.EmptyIcon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

// must implement AnAction instead of QuickSwitchSchemeAction
// still throwing " IllegalStateException: class with name 'com.developerphil.adbidea.action.QuickListAction' must be an instance of 'com.intellij.openapi.actionSystem.AnAction'; got null (null)

public class QuickListAction extends AnAction {


    protected QuickListAction() {
        this(false);
    }

    protected QuickListAction(boolean showPopupWithNoActions) {
        this.myActionPlace = "unknown";
        this.myShowPopupWithNoActions = showPopupWithNoActions;
    }


    protected void fillActions(@Nullable final Project project,
                               @NotNull final DefaultActionGroup group,
                               @NotNull final DataContext dataContext) {

        if (project == null) {
            return;
        }

        addAction("com.developerphil.adbidea.action.UninstallAction", group);
        addAction("com.developerphil.adbidea.action.KillAction", group);
        addAction("com.developerphil.adbidea.action.StartAction", group);
        addAction("com.developerphil.adbidea.action.RestartAction", group);
        addAction("com.developerphil.adbidea.action.ClearDataAction", group);
        addAction("com.developerphil.adbidea.action.ClearDataAndRestartAction", group);
    }

    protected boolean isEnabled() {
        return true;
    }

    private void addAction(final String actionId, final DefaultActionGroup toGroup) {
        final AnAction action = ActionManager.getInstance().getAction(actionId);

        // add action to group if it is available
        if (action != null) {
            toGroup.add(action);
        }
    }

    protected String getPopupTitle(AnActionEvent e) {
        return "ADB Operations Popup";
    }

    protected static final Icon ourCurrentAction;
    protected static final Icon ourNotCurrentAction;
    @NotNull
    protected String myActionPlace;
    private final boolean myShowPopupWithNoActions;


    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = (Project)e.getData(CommonDataKeys.PROJECT);
        DefaultActionGroup group = new DefaultActionGroup();
        this.fillActions(project, group, e.getDataContext());
        this.showPopup(e, group);
    }

//    protected abstract void fillActions(Project var1, @NotNull DefaultActionGroup var2, @NotNull DataContext var3);

    private void showPopup(AnActionEvent e, DefaultActionGroup group) {
        if(this.myShowPopupWithNoActions || group.getChildrenCount() != 0) {
            ListPopup popup = JBPopupFactory.getInstance().createActionGroupPopup(this.getPopupTitle(e), group, e.getDataContext(), this.getAidMethod(), true, this.myActionPlace);
            this.showPopup(e, popup);
        }
    }

    protected void showPopup(AnActionEvent e, ListPopup popup) {
        Project project = e.getProject();
        if(project != null) {
            popup.showCenteredInCurrentWindow(project);
        } else {
            popup.showInBestPositionFor(e.getDataContext());
        }

    }

    protected JBPopupFactory.ActionSelectionAid getAidMethod() {
        return JBPopupFactory.ActionSelectionAid.NUMBERING;
    }

//    protected String getPopupTitle(AnActionEvent e) {
//        return e.getPresentation().getText();
//    }

    public void update(@NotNull AnActionEvent e) {
        super.update(e);
        e.getPresentation().setEnabled(e.getData(CommonDataKeys.PROJECT) != null && this.isEnabled());
    }

//    protected abstract boolean isEnabled();

    static {
        ourCurrentAction = AllIcons.Diff.CurrentLine;
        ourNotCurrentAction = new EmptyIcon(ourCurrentAction.getIconWidth(), ourCurrentAction.getIconHeight());
    }
}
