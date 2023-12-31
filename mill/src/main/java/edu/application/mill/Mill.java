package edu.application.mill;

import edu.application.mill.bean.Flour;
import edu.application.mill.bean.Millet;
import edu.application.mill.bean.Water;
import edu.application.mill.engine.Engine;
import edu.application.mill.engine.WaterWheel;
import edu.application.mill.machine.Machine;
import edu.application.mill.machine.MillStone;

import java.util.Queue;

public class Mill extends Thread {

    private final Engine engine;
    private final Machine machine;


    public Mill(Queue<Water> waterFlow, Queue<Millet> milletFlow, Queue<Flour> flourFlow) {
        this.engine = new WaterWheel(waterFlow);
        this.engine.start();

        this.machine = new MillStone(engine, milletFlow, flourFlow);
        this.machine.start();
    }

    public boolean isMachineOn() {
        return this.machine.isOn();
    }

    public boolean isEngineOn() {
        return this.engine.getPower() > 0;
    }

    public int getPower(){
        return this.engine.getPower();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            if (engine.getPower() > 0) {
                machine.on();
            }
        }
    }
}
