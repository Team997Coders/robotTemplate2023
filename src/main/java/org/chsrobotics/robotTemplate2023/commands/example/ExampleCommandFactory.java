/**
Copyright 2023 FRC Team 997

This program is free software: 
you can redistribute it and/or modify it under the terms of the 
GNU General Public License as published by the Free Software Foundation, 
either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, 
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program. 
If not, see <https://www.gnu.org/licenses/>.
*/
package org.chsrobotics.robotTemplate2023.commands.example;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import java.util.function.DoubleSupplier;
import org.chsrobotics.lib.controllers.feedback.PID;
import org.chsrobotics.robotTemplate2023.Constants.COMMANDS.EXAMPLE.*;
import org.chsrobotics.robotTemplate2023.subsystems.exampleSubsystem.ExampleSubsystem;

public class ExampleCommandFactory {
    public static CommandBase getExampleSetMotorCommand(
            ExampleSubsystem subsystem, DoubleSupplier voltageLambda) {
        return Commands.startEnd(
                () -> subsystem.setMotorVoltage(voltageLambda),
                () -> subsystem.setMotorVoltage(0),
                subsystem);
    }

    public static CommandBase getExampleSetMotorCommand(
            ExampleSubsystem subsystem, double voltage) {
        return getExampleSetMotorCommand(subsystem, () -> voltage);
    }

    public static CommandBase getExamplePositionCommand(
            ExampleSubsystem subsystem, DoubleSupplier setpoint) {
        PID pid = new PID(CONTROLLER.POSITION_PID_CONSTANTS, setpoint.getAsDouble(), true);

        return getExampleSetMotorCommand(
                subsystem, () -> pid.calculate(subsystem.getAbsolutePositionRadians()));
    }

    public static CommandBase getExamplePositionCommand(
            ExampleSubsystem subsystem, double setpoint) {
        return getExamplePositionCommand(subsystem, () -> setpoint);
    }

    public static CommandBase getExampleVelocityCommand(
            ExampleSubsystem subsystem, DoubleSupplier setpoint) {
        PID pid = new PID(CONTROLLER.VELOCITY_PID_CONSTANTS, setpoint.getAsDouble(), false);

        return getExampleSetMotorCommand(
                subsystem, () -> pid.calculate(subsystem.getVelocityRadiansPerSecond()));
    }

    public static CommandBase getExampleVelocityCommand(
            ExampleSubsystem subsystem, double setpoint) {
        return getExampleVelocityCommand(subsystem, () -> setpoint);
    }
}
