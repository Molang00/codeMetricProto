package com.cherrybox.calculator;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.project.Project;

import java.io.File;
import java.io.IOException;

public class CodeMetric {
    private static MetricsManager mManager;
    private VirtualFile targetVirtualFile;
    private PsiFile targetPsiFile;
    private Project project;

    public CodeMetric(){

    }

    public static void calculateCodeMetric() {
        mManager = new MetricsManager();
        System.out.println("start");

        exitReport();
        System.out.println("end");
    }

    public void getTargetFile(String tf){
        PsiManager psiManager = PsiManager.getInstance(this.project);
        File f = new File(tf);
        targetVirtualFile = LocalFileSystem.getInstance().findFileByIoFile(f);
        targetPsiFile = psiManager.findFile(targetVirtualFile);
    }

    public static String exitReport(){
        try {
            return mManager.exitReport();
        } catch (IOException e1) {
            System.out.println("error");
            return "error";
        }
    }
}