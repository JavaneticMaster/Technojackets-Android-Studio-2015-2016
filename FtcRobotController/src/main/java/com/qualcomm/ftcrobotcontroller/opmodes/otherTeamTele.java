package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Sam Mader on 2/6/2016.
 */
public class otherTeamTele extends OpMode {
    DcMotor leftMotor, rightMotor, tape, winch;

    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        tape = hardwareMap.dcMotor.get("tape");
        winch = hardwareMap.dcMotor.get("winch");
    }

    @Override
    public void loop() {
        double leftPower = -gamepad1.left_stick_y;
        double rightPower = -gamepad1.right_stick_y;
        double tapePower = -gamepad2.left_stick_y;
        double winchPower = -gamepad2.right_stick_y;

        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
        tape.setPower(tapePower);
        winch.setPower(winchPower);



    }

}
