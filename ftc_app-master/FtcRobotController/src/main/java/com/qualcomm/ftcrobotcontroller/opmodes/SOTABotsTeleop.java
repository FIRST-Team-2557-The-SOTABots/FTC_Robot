package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


/**
 * Created by Antonio on 11/19/2015.
 */
public class SOTABotsTeleop extends OpMode{
    DcMotorController wheelController;
    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotorController armController;
    DcMotor armMotor;
    DcMotor climberMotor;
    Servo scoopServo;


    public void init(){
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        armMotor = hardwareMap.dcMotor.get("armMotor");
        climberMotor = hardwareMap.dcMotor.get("climberMotor");
        scoopServo = hardwareMap.servo.get("scoopServo");



    }
    public void loop(){
        DoTank();
        DoScoop();
        DoArm();
    }
    public void DoTank(){
        double leftPower = gamepad1.left_stick_y;
        double rightPower = gamepad1.right_stick_y;
        double climberPower = gamepad2.right_stick_y;


        leftPower = Range.clip(leftPower, -1.0, 1.0);
        rightPower = Range.clip(rightPower, -1.0, 1.0);
        climberPower = Range.clip(climberPower, -1.0, 1.0);

        motorLeft.setPower(leftPower);
        motorRight.setPower(rightPower);
        climberMotor.setPower(climberPower);



    }
    public void DoScoop() {

        if (gamepad2.a) {
            scoopServo.setPosition(0.3);
            return;
        }
        if (gamepad2.b) {
            scoopServo.setPosition(0.7);
        }
        if (gamepad2.x) {
            scoopServo.setPosition(0.5);
        }
    }
    public void DoArm() {
        double armPower = gamepad2.left_stick_y;

        armPower = Range.clip(armPower, -1.0, 1.0);

        armMotor.setPower(armPower);
    }



}



