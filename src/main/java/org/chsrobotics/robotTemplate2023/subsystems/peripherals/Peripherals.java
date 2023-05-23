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
package org.chsrobotics.robotTemplate2023.subsystems.peripherals;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj2.command.Subsystem;
import org.chsrobotics.robotTemplate2023.Constants.SUBSYSTEMS.PERIPHERALS.*;

public class Peripherals implements Subsystem {
    public Peripherals() {
        register();
    }

    public void startCameraStreams() {
        UsbCamera camera = CameraServer.startAutomaticCapture();

        camera.setResolution(CAMERA.HORIZONTAL_RESOLUTION_PX, CAMERA.VERTICAL_RESOLUTION_PX);
        camera.setFPS(CAMERA.FPS_LIMIT);
    }

    public double getTotalCurrentDraw() {
        return 0; // on real robot, this is a reference to actual hardware state
    }

    public double getPneumaticsPressure() {
        return 0; // on real robot, this is a reference to actual hardware state
    }
}
