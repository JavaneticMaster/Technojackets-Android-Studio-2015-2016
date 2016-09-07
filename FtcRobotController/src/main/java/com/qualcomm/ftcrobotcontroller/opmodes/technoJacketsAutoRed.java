package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Sam Mader on 1/4/2016.
 */

public class technoJacketsAutoRed extends LinearOpMode {
    DcMotor motorL, motorR, sweeper, arm2;

    @Override
    public void runOpMode() throws InterruptedException {
        motorL = hardwareMap.dcMotor.get("leftMotor");
        motorR = hardwareMap.dcMotor.get("rightMotor");
        sweeper = hardwareMap.dcMotor.get("sweeper");
        arm2 = hardwareMap.dcMotor.get("arm2");

        waitForStart();
        arm2.setPower(.1);
        sleep(500);
        motorL.setPower(1);
        motorR.setPower(-1);
        sleep(547);
        motorL.setPower(0);
        motorR.setPower(0);
        sleep(1000);
        motorL.setPower(0.5);
        motorR.setPower(0.5);
        sleep(1350);
        motorL.setPower(1);
        motorR.setPower(-1);
        sweeper.setPower(0.9);
        sleep(4500);
        motorL.setPower(0);
        motorR.setPower(0);
        sweeper.setPower(0);
        sleep(1000);
        motorL.setPower(0.5);
        motorR.setPower(0.5);
        sleep(1350);
        motorL.setPower(0);
        motorR.setPower(0);
        sleep(500);
        motorL.setPower(1);
        motorR.setPower(-1);
        sleep(1550);
        motorL.setPower(0);
        motorR.setPower(0);

    }
}
