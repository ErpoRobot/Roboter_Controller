package com.example.expresso.myapplication;

/**
 * Created by donborito on 15.12.16.
 */

public class Motor_Controller {
    public enum Motor_Side {left, right};

    public enum Driving_Direction {forwards, backwards, none};

    public void drive(Motor_Side motor_side, Driving_Direction direction) {

        byte[] command;
        // motor id
        byte motor = 0x00;
        byte motorSpeed = 0x00;
        // select motor id
        switch (motor_side) {
            case left:
                motor = 0x01;
                break;
            case right:
                motor = 0x00;
                break;
        }
        // select driving direction (motorSpeed)
        switch (direction) {
            case forwards:
                motorSpeed = 0x32;

                break;
            case backwards:


                break;
            default:
                motorSpeed = 0x00;
                break;
        }
        // create command byte
        command = new byte[]{0x0C,0x00,0x00,0x04,motor,motorSpeed,0x05,0x01,motorSpeed,0x20,0x00,0x00,0x00,0x00};
        // send command to robot
        Global.connector.send(command);

    }
}
