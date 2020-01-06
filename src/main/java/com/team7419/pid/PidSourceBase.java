package com.team7419.pid;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

/**
 * this is all deprecated but until we figure out how to make a pidcontroller properly
 * using wpilibj2 i dont want to get rid of it
 */
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