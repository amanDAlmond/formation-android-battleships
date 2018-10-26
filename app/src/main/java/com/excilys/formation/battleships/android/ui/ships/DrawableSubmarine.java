package com.excilys.formation.battleships.android.ui.ships;

import java.util.HashMap;
import java.util.Map;

import battleships.formation.excilys.com.battleships.R;
import battleships.ship.BattleShip;

/**
 * Created by scaltot on 12/09/17.
 */

public class DrawableSubmarine extends BattleShip implements DrawableShip {

    private static final Map<Orientation, Integer> DRAWABLES = new HashMap<>();


    static {
        DRAWABLES.put(Orientation.NORTH, R.drawable.submarine_n);
        DRAWABLES.put(Orientation.SOUTH, R.drawable.submarine_s);
        DRAWABLES.put(Orientation.EAST, R.drawable.submarine_e);
        DRAWABLES.put(Orientation.WEST, R.drawable.submarine_w);
    }
    // key = the ship orientation and value = the drawable corresponding



    @Override
    public int getDrawable() {
        return DRAWABLES.get(this.getOrientation());
    }
}
