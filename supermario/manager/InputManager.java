package manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener{

    private GameEngine engine;

    InputManager(GameEngine engine) {
        this.engine = engine; }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        GameStatus status = engine.getGameStatus();
        ButtonAction currentAction = ButtonAction.NO_ACTION;

        if (keyCode == KeyEvent.VK_UP) {
            if(status == GameStatus.START_SCREEN || status == GameStatus.MAP_SELECTION)
                currentAction = ButtonAction.GO_UP;
            else
                currentAction = ButtonAction.JUMP;
        }
        else if(keyCode == KeyEvent.VK_DOWN){
            if(status == GameStatus.START_SCREEN || status == GameStatus.MAP_SELECTION)
                currentAction = ButtonAction.GO_DOWN;
            else if(status==GameStatus.RUNNING){
                currentAction = ButtonAction.CROUCH;
                currentAction = ButtonAction.M_DOWN;
            }
                
        }
        else if (keyCode == KeyEvent.VK_RIGHT) {
            currentAction = ButtonAction.M_RIGHT;
        }   
        else if (keyCode == KeyEvent.VK_LEFT) {
            currentAction = ButtonAction.M_LEFT;
        }
        else if (keyCode == KeyEvent.VK_ENTER) {
            currentAction = ButtonAction.SELECT;
        }
        else if (keyCode == KeyEvent.VK_ESCAPE) {
            if(status == GameStatus.RUNNING || status == GameStatus.PAUSED )
                currentAction = ButtonAction.PAUSE_RESUME;
            else
                currentAction = ButtonAction.GO_TO_START_SCREEN;

        }
        else if (keyCode == KeyEvent.VK_SPACE){
            if(status == GameStatus.RUNNING)
            {
                currentAction = ButtonAction.FIRE;
            }
            else if(status == GameStatus.MISSION_PASSED)
            {
                currentAction = ButtonAction.GO_TO_NEXT_LEVEL;
            }
        }


        notifyInput(currentAction);
    }

   

    @Override
    public void keyReleased(KeyEvent event) {
        if(event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_LEFT)
            notifyInput(ButtonAction.ACTION_COMPLETED);
    }

    private void notifyInput(ButtonAction action) {
        if(action != ButtonAction.NO_ACTION)
            engine.receiveInput(action);
    }

    @Override
    public void keyTyped(KeyEvent arg0) {}

}
