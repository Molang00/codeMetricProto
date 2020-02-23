package com.cherrybox;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.project.Project;

import java.io.File;
import java.io.IOException;

public class codeMetric {
    private static metricsManager mManager;
    private VirtualFile targetVirtualFile;
    private PsiFile targetPsiFile;
    private Project project;

    public codeMetric(){

    }

    public static void main(String[] args) throws IOException {
        mManager = new metricsManager();
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

    public static void exitReport(){
        try {
            mManager.exitReport();
        } catch (IOException e1) {
            System.out.println("error");
        }
    }
}