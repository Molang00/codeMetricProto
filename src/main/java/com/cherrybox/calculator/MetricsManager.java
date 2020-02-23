package com.cherrybox.calculator;

import com.cherrybox.calculator.metrics.LOCMetric;
import com.cherrybox.calculator.metrics.Metric;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class MetricsManager {
    private List<Metric> metrics;
    public MetricsManager(){
        Metric LOC = new LOCMetric("LOC");
        metrics = Arrays.asList(LOC);
    }

    public String exitReport() throws IOException {
        double total = 0;
        double error = 0;
        String report = "";
        PrintWriter pw = new PrintWriter("out.txt");
        report += "이 코드는 일반적인 코드에 비해 ";
        for (Metric m : metrics) {
            String sentance = m.generateReport();
            report += sentance;
            total++;
            if (sentance.contains("매우"))
                error++;
        }
        double errorPercent = error / total;
        if (errorPercent < 0.25) {
            report += "유지 및 보수하기 좋은 구조로 되어 있습니다.\n";
        } else if (errorPercent < 0.75) {
            report += "평범한 수준으로 개발되어 있습니다.\n";
        } else {
            report += "전체적으로 수정이 요구됩니다.\n";
        }
        System.out.println(report);
        return report;
    }
}
