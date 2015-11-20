package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by Antonio on 11/20/2015.
 */
public class SOTABotsAuto extends LinearOpMode {

    ////Declare your Variables///
    DcMotor motorLeft;
    DcMotor motorRight;
    Servo scoopServo;
    ////Declare your Variabels^^^^////


    public void runOpMode() throws InterruptedException{
        ////Map the variables to your objects if need be////
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        scoopServo = hardwareMap.servo.get("scoopServo");
        ////Map the variables to your objects if need be^^^^////

        ////This tells the code to wait until the Start button has been activated on the driver station////
        waitForStart();

        while (opModeIsActive()){

            motorLeft.setPower(.3);
            motorRight.setPower(.3);

            sleep(1000);

            motorLeft.setPowerFloat();
            motorRight.setPowerFloat();




        }


    }








}
