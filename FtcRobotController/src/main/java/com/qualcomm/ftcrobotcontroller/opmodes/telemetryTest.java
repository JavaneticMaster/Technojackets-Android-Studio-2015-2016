package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.robocol.Telemetry;

/**
 * Created by scpatterson on 2/4/2016.
 */
public class telemetryTest extends OpMode {
    Telemetry telemetry1, telemetry2, telemetry3;

    @Override
    public void init() {
        telemetry1.addData("Gamepad Y Data:", -gamepad1.left_stick_y);
        telemetry2.addData("Gamepad X Data:", gamepad1.left_stick_x);
        telemetry3.addData("Calculation:", (gamepad1.left_stick_x + 1.0) * 0.5);
    }

    @Override
    public void loop() {
        telemetry1.addData("Gamepad Y Data:", -gamepad1.left_stick_y);
        telemetry2.addData("Gamepad X Data:", gamepad1.left_stick_x);
        telemetry3.addData("Calculation:", (gamepad1.left_stick_x + 1.0) * 0.5);
    }
}
