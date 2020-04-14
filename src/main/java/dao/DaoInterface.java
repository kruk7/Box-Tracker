package dao;

import model.Box;
import model.Coordinates;
import model.User;

public interface DaoInterface
{
    public void addUser(User user);
    public void addBox(Box box);
    public void addCoordinates(Coordinates coordinates);

    public void addCoordinatesToBox(Long BoxId, Coordinates coordinates);
    public void addBoxToUser(Long UserId, Box box);

    public User getUser(Long UserId);
    public Box getBox(Long BoxId);
    public Coordinates getCoordinates(Long CoordinatesId);

}
