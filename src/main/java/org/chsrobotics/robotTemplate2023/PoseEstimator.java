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

import edu.wpi.first.math.geometry.Pose3d;

public class PoseEstimator {

    @FunctionalInterface
    public static interface ForwardModel {
        Pose3d getNextPose(Pose3d currentPose, double input, double dtSeconds);
        // in reality input would be an object designed for encapsulating your drivetrain inputs,
        // and would be multi-dimensional
    }

    public PoseEstimator(ForwardModel model) {}

    public Pose3d getPoseEstimate(double input) { // same input from ForwardModel
        return null;
    }

    public void addEstimate(Pose3d estimate, double timestampSeconds) {}
}
