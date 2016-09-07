package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Sam Mader on 1/9/2016.
 */
public class servoTest extends OpMode {
    Servo servo1, servo2, servo3, servo4;

    @Override
    public void init() {
        servo1 = hardwareMap.servo.get("servo1");
        servo2 = hardwareMap.servo.get("servo2");
        servo3 = hardwareMap.servo.get("servo3");
        servo4 = hardwareMap.servo.get("servo4");
    }

    @Override
    public void loop() {

        if (gamepad1.x) {
            servo1.setPosition(90);
            servo2.setPosition(90);
        }

        if (gamepad1.b) {
            servo1.setPosition(0);
            servo2.setPosition(0);
        }

        if (gamepad1.a) {
            servo3.setPosition(90);
            servo4.setPosition(90);
        }

        if (gamepad1.y) {
            servo3.setPosition(0);
            servo4.setPosition(0);
        }
    }
}
