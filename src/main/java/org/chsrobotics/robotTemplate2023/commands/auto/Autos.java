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
package org.chsrobotics.robotTemplate2023.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import org.chsrobotics.robotTemplate2023.commands.example.ExampleCommandFactory;
import org.chsrobotics.robotTemplate2023.subsystems.exampleSubsystem.ExampleSubsystem;

public class Autos {
    public static CommandBase getExampleAutoA(ExampleSubsystem exampleSubsystem) {
        return new SequentialCommandGroup(
                ExampleCommandFactory.getExamplePositionCommand(exampleSubsystem, 0).withTimeout(1),
                Commands.waitSeconds(2),
                ExampleCommandFactory.getExamplePositionCommand(exampleSubsystem, Math.PI)
                        .withTimeout(1));
    }

    public static CommandBase getExampleAutoB(ExampleSubsystem exampleSubsystem) {
        return new SequentialCommandGroup(
                ExampleCommandFactory.getExampleSetMotorCommand(exampleSubsystem, 6).withTimeout(3),
                Commands.waitSeconds(2),
                ExampleCommandFactory.getExamplePositionCommand(exampleSubsystem, 1.5 * Math.PI));
    }
}
