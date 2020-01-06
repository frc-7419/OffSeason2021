package com.team7419.pid;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public abstract class PidSourceBase implements PIDSource{
    PIDSourceType type;
 
    @Override
        public void setPIDSourceType(PIDSourceType pidSource){
            type = pidSource;
        }
    @Override
    public PIDSourceType getPIDSourceType(){
        return type;
    }

}