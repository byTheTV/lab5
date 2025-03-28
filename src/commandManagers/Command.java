package commandManagers;

import collectionManagers.StudyGroupCollectionManager;
import exceptions.BuildObjectException;
import models.*;

import java.time.LocalDate;
import java.util.Scanner;

/**
 Abstract class representing a command that can be executed in the program.
 */
public abstract class Command implements CommandInterface {

    /**
     Boolean indicating whether this command requires an argument or not.
     */
    private final boolean hasArgument;

    /**
     The argument for this command.
     */
    protected String argument;

    /**
     The collection manager for this command.
     */
    protected StudyGroupCollectionManager collectionManager;

    /**
     * Base method for show command name
     *
     * @return command name
     */
    @Override
    public abstract String getName();

    /**
     * Base method for show command description.
     *
     * @return command description
     */
    @Override
    public abstract String getDescr();

    /**
     Constructs a new command with the specified argument requirement and collection manager.
     @param hasArgument a boolean indicating whether this command requires an argument or not.
     @param collectionManager the collection manager for this command.
     */
    public Command(boolean hasArgument, StudyGroupCollectionManager collectionManager) {
        this.hasArgument = hasArgument;
        this.collectionManager = collectionManager;
    }



    /**
     Constructs a new command with the specified argument requirement.
     @param hasArgument a boolean indicating whether this command requires an argument or not.
     */
    public Command(boolean hasArgument) {
        this.hasArgument = hasArgument;
        this.collectionManager = null;
    }

    /**
     Executes command.
     */
    @Override
    public abstract void execute() throws BuildObjectException;

    /**
     Checks if the given inputArgument is valid for this command.
     @param inputArgument the argument to check.
     @return true if the argument is valid, false otherwise.
     */
    @Override
    public abstract boolean checkArgument(Object inputArgument);

    /**
     Returns whether this command requires an argument.
     @return true if this command requires an argument, false otherwise.
     */
    public boolean isHasArgument() {
        return hasArgument;
    }

    /**
     Returns the argument for this command.
     @return the argument for this command.
     */
    public String getArgument() {
        return argument;
    }

    /**
     Sets the argument for this command.
     @param argument the argument to set.
     */
    public void setArgument(String argument) {
        this.argument = argument;
    }

}
