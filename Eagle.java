public class Eagle extends Bird implements Fly{

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return this.altitude;
    }

    public void setAltitude(int altitude){
        this.altitude += altitude;
    }

    public boolean isFlying() {
        return this.flying;
    }

    public void setIsFlying(boolean flying){
        this.flying = flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    @Override
    public void takeOff(){
        if(!this.flying) {
            this.setIsFlying(true);
            System.out.println(this.getName() + " takes off in the sky.");
        } else {
            System.out.println(this.getName() + " is already flying.");
        }
    }

    @Override
    public void glide(){
        if(!this.flying) {
            System.out.println(this.getName() + " isn't flying.");
        } else {
            System.out.println("It glides into the air.");
        }
    }

    @Override
    public void land(){
        if(this.isFlying() && this.getAltitude() == 0){
            this.setIsFlying(false);
            System.out.println(this.getName() + " lands on the ground.");
        } else if(this.getAltitude() > 0 && this.flying) {
            System.out.println(this.getName() + " is too high and can't land.");
        } else {
            System.out.println(this.getName() + " isn't flying.");
        }
    }

    @Override
    public void ascend(int altitude){
        if(!this.flying) {
            this.takeOff();
            this.ascend(altitude);
        } else {
            this.setAltitude(altitude);
            System.out.println(this.getName() + " flies upward, altitude : " + this.getAltitude());
        }
    }

    @Override
    public void descend(int altitude){
        if(!this.flying) {
            System.out.println(this.getName() + " isn't flying.");
        } else {
            this.setAltitude(- altitude);
            if(this.getAltitude() > 0) {
                System.out.println(this.getName() + " flies downward, altitude : " + this.getAltitude());
            } else {
                this.setAltitude(- this.getAltitude());
                System.out.println(this.getName() + " flies downward, altitude : " + this.getAltitude());
                this.land();
            }
        }
    }
}
