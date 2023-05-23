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
package org.chsrobotics.robotTemplate2023.subsystems.exampleSubsystem;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.function.DoubleSupplier;
import org.chsrobotics.lib.telemetry.Logger;

public abstract class ExampleSubsystem extends SubsystemBase {
    private final String subdirString = "exampleSubsystem";

    private final Logger<Double> absolutePositionLogger =
            new Logger<>("absolutePosition_radians", subdirString);

    private final Logger<Double> velocityLogger =
            new Logger<>("velocity_rad_p_second", subdirString);

    public abstract double getAbsolutePositionRadians();

    public abstract double getVelocityRadiansPerSecond();

    public abstract void setMotorVoltage(DoubleSupplier voltageLambda);

    public void setMotorVoltage(double volts) {
        setMotorVoltage(() -> volts);
    }

    @Override
    public void periodic() {
        absolutePositionLogger.update(getAbsolutePositionRadians());

        velocityLogger.update(getVelocityRadiansPerSecond());
    }

    public static ExampleSubsystem getInstance(boolean robotIsReal) {
        if (robotIsReal) return new ExampleSubsystemHardware();
        else return new ExampleSubsystemSim();
    }
}
