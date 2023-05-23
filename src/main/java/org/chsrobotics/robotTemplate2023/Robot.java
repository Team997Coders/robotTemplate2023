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
package org.chsrobotics.robotTemplate2023;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import org.chsrobotics.lib.telemetry.HighLevelLogger;
import org.chsrobotics.robotTemplate2023.commands.example.ExampleCommandFactory;
import org.chsrobotics.robotTemplate2023.subsystems.exampleSubsystem.ExampleSubsystem;

public class Robot extends TimedRobot {
    private final ExampleSubsystem exampleSubsystem = ExampleSubsystem.getInstance(isReal());

    @Override
    public void robotPeriodic() {
        HighLevelLogger.getInstance().updateLogs();

        CommandScheduler.getInstance().run();
    }

    @Override
    public void autonomousPeriodic() {}

    @Override
    public void teleopPeriodic() {}

    @Override
    public void testPeriodic() {}

    @Override
    public void disabledPeriodic() {}

    @Override
    public void robotInit() {
        HighLevelLogger.getInstance().autoGenerateLogs("", "");
        HighLevelLogger.getInstance().logMessage("Robot code initialized");
    }

    @Override
    public void autonomousInit() {}

    @Override
    public void teleopInit() {
        CommandScheduler.getInstance()
                .schedule(ExampleCommandFactory.getExamplePositionCommand(exampleSubsystem, 1));
    }

    @Override
    public void testInit() {}

    @Override
    public void disabledInit() {}
}
