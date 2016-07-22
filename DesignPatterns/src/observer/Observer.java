package observer;

import java.util.Observable;

/**
 * Created by azburatura on 7/22/2016.
 */
public class Observer {

    public static void main(String[] args) {

        NewsSubscriber newsSubscriber = new NewsSubscriber();
        FacebookStream facebookStream = new FacebookStream();

        ClientNews clientNews1 = new ClientNews("Adrian");
        ClientNews clientNews2 = new ClientNews("Ilinca");
        ClientNews clientNews3 = new ClientNews("Adriana");
        ClientNews clientNews4 = new ClientNews("Laviia");
        ClientFacebook clientFacebook1 = new ClientFacebook("Adrian");
        ClientFacebook clientFacebook2 = new ClientFacebook("Lavinia");

        newsSubscriber.addObserver(clientNews1);
        newsSubscriber.addObserver(clientNews2);
        newsSubscriber.addObserver(clientNews3);
        newsSubscriber.addObserver(clientNews4);
        facebookStream.addObserver(clientFacebook1);
        facebookStream.addObserver(clientFacebook2);

        newsSubscriber.publishNewArticle();
        facebookStream.shareSomething();
    }
}


class NewsSubscriber extends Observable {
    public void publishNewArticle() {
        setChanged();
        notifyObservers();
    }

}

class FacebookStream extends Observable {
    public void shareSomething() {
        setChanged();
        notifyObservers();
    }
}

class ClientNews implements java.util.Observer {

    public String nume;

    public ClientNews(String nume) {
        this.nume = nume;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update " + nume + "'s mail, you can read a new article.");
    }
}

class ClientFacebook implements java.util.Observer {

    public String nume;

    public ClientFacebook(String nume) {
        this.nume = nume;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update " + nume + "'s news feed, you can see what your friend shared.");
    }
}

