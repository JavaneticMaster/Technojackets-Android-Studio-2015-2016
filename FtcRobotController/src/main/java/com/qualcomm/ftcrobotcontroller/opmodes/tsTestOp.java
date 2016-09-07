package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by Sam Mader on 1/14/2016.
 */
public class tsTestOp extends OpMode {
    TouchSensor ts;
    DcMotor leftMotor, rightMotor;

    @Override
    public void init() {
        ts = hardwareMap.touchSensor.get("ts");
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
    }

    @Override
    public void loop() {

        if (ts.isPressed()) {
            leftMotor.setPower(1);
            rightMotor.setPower(1);
        }
        else {
            leftMotor.setPower(1);
            rightMotor.setPower(1);
        }

    }
}
