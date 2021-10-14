package io.github.ziqicongdonglai.java.basic.temp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ke_zhang
 * @create 2021-10-14 10:17
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Computer {
    private String brand;
    private String color;
    private String cpu;
    private String memory;
    private String hardDisk;
    private Double price;
    private String workStatus;
    public void start() {
        System.out.println("电脑开机");
    }

    public void off() {
        System.out.println("电脑关机");
    }
}
