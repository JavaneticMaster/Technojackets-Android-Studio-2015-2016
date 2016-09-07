package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by scpatterson on 2/2/2016.
 */
public class armTest extends OpMode {
    DcMotor arm1, sweeper;

    @Override
    public void init() {
        arm1 = hardwareMap.dcMotor.get("arm1");
        sweeper = hardwareMap.dcMotor.get("sweeper");
    }

    @Override
    public void loop() {
         float arm1Power = -gamepad1.left_stick_y;
         double sweeperPower = sweeper.getPower();
         if (gamepad1.right_bumper) {
             if (sweeperPower <= 0) {
                 sweeper.setPower(.9);
             }
             else if (sweeperPower > 0) {
                 sweeper.setPower(0);
             }
         }

         arm1.setPower(arm1Power);

    }
}
