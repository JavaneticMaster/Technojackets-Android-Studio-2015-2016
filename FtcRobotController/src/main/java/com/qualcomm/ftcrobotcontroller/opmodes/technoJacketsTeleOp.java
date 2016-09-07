package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Sam Mader on 1/14/2016.
 */
public class technoJacketsTeleOp extends OpMode {
    // Declare robot parts.
    DcMotor motorL, motorR, arm1, arm2, sweeper, turret;
    Servo servo1;

    @Override
    public void init() {
        // Assign robot parts to config file counterparts.
        motorL = hardwareMap.dcMotor.get("leftMotor");
        motorR = hardwareMap.dcMotor.get("rightMotor");
        arm1 = hardwareMap.dcMotor.get("arm1");
        arm2 = hardwareMap.dcMotor.get("arm2");
        sweeper = hardwareMap.dcMotor.get("sweeper");
        turret = hardwareMap.dcMotor.get("turret");
        servo1 = hardwareMap.servo.get("servo1");
    }

    @Override
    public void loop() {
        // Declare powerMod variable.
        float powerMod;

        // Uses powerMod to make a "Turbo" button
        if (gamepad2.left_bumper) {
            powerMod = 0.75F;
        }
        else {
            powerMod = 0.3F;
        }

        // Declares robot parts to be controller sticks.
        float motorLPower = gamepad1.left_stick_y;
        float motorRPower = gamepad1.right_stick_y * -1;
        float arm1Power = -gamepad2.left_stick_y;
        float arm2Power = -gamepad2.right_stick_y;
        double servoPos = (gamepad2.left_stick_x+1.0)*.5;
        float turretPower = -gamepad2.right_stick_x * powerMod;

        // Creates a parabola value for the arm while not allowing it to exceed -1 or 1.
        double newPower = Math.pow(arm1Power, 2);
        Range.clip(newPower, -1, 1);

        // Variable of sweeper motor power.
        double sweeperPower = sweeper.getPower();


        // Sets motor speeds to controller sticks.
        motorL.setPower(motorLPower);
        motorR.setPower(motorRPower);
        arm1.setPower(newPower);
        arm2.setPower(arm2Power);



        // Sets turret power to variable.
        turret.setPower(turretPower);

        // Sets servo to return to original position when controller stick is released.
        if(servoPos<0)
            servoPos = 0;
        if(servoPos>1)
            servoPos = 1;

        // Sets servo position to variable.
        servo1.setPosition(servoPos);

        // Turns on motor for sweeping and off with another push.
        if (gamepad1.a) {
            if (sweeperPower <= 0) {
                sweeper.setPower(0.9);
            }
            else {
                sweeper.setPower(0);
            }
        }

        // Turns on motor for pushing and off with another push.
        if (gamepad1.y) {
            if (sweeperPower >= 0) {
                sweeper.setPower(-0.9);
            }
            else {
                sweeper.setPower(0);
            }

        }

    }

}
