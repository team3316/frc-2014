/**
 * Class for joysticks and joystick buttons
 */
package org.usfirst.frc.team3316.robot.humanIO;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.config.Config;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;
import org.usfirst.frc.team3316.robot.logger.DBugLogger;

public class Joysticks {
  /*
   * Defines a button in a gamepad POV for an array of angles
   */
  private class POVButton extends Button {
    Joystick m_joystick;
    int m_deg;

    public POVButton (Joystick joystick, int deg) {
      m_joystick = joystick;
      m_deg = deg;
    }

    public boolean get () {
      if (m_joystick.getPOV() == m_deg) {
        return true;
      }
      return false;
    }
  }

  Config config = Robot.config;
  DBugLogger logger = Robot.logger;

  private Joystick mLeftJoystick, mRightJoystick;

  public Joysticks () throws ConfigException {
    this.mLeftJoystick = new Joystick((int) this.config.get("joysticks.left"));
    this.mRightJoystick = new Joystick((int) this.config.get("joysticks.right"));
  }

  public void initButtons () {
    // TODO - Build
  }

  public double getLeftDriver () {
    return this.mLeftJoystick.getY();
  }

  public double getRightDriver () {
    return this.mRightJoystick.getY();
  }
}
