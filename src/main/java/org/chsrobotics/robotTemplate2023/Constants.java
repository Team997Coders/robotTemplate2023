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

import edu.wpi.first.math.system.plant.DCMotor;
import org.chsrobotics.lib.controllers.feedback.PID.PIDConstants;
import org.chsrobotics.lib.util.GearRatioHelper;

public final class Constants {
    public static final class COMMANDS {
        public static final class EXAMPLE {
            public static final class CONTROLLER {
                public static final PIDConstants POSITION_PID_CONSTANTS = new PIDConstants(1, 0, 0);

                public static final PIDConstants VELOCITY_PID_CONSTANTS = new PIDConstants(1, 0, 0);
            }
        }
    }

    public static final class SUBSYSTEMS {
        public static final class EXAMPLE_SUBSYSTEM {
            public static final class PORTS {
                public static final int MOTOR_CAN_ID = 0;
            }

            public static final class PHYSICS {
                public static final DCMotor MOTOR = DCMotor.getCIM(1);

                public static final GearRatioHelper GEARING = new GearRatioHelper(1, 5);

                public static final double MOMENT_KG_M_M = 1;
            }
        }

        public static final class PERIPHERALS {
            public static final class CAMERA {
                public static final int HORIZONTAL_RESOLUTION_PX = 360;
                public static final int VERTICAL_RESOLUTION_PX = 360;

                public static final int FPS_LIMIT = 15;
            }
        }
    }
}
