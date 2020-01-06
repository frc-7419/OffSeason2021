package com.team7419.templates;

import edu.wpi.first.wpilibj.command.Command;

public class TemplateCommand extends Command{

    public TemplateCommand(){
        // requires(Robot.subsystem);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){

    }

    @Override
    public void end(){

    }

    @Override
    public void interrupted(){
        end();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}