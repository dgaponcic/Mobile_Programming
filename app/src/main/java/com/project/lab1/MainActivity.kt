package com.project.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.project.lab1.feed.FeedActivity
import com.project.lab1.feed.models.FeedItem
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var posts = intent.getSerializableExtra("posts")

        val messageText: TextView = findViewById(R.id.messageText)
        if (posts == null) {
            posts = arrayOf(
                    FeedItem(
                            "aka14fkr",
                            "Sad story :/",
                            "https://cdn.vox-cdn.com/thumbor/cV8X8BZ-aGs8pv3D-sCMr5fQZyI=/1400x1400/filters:format(png)/cdn.vox-cdn.com/uploads/chorus_asset/file/19933026/image.png"
                    ),
                    FeedItem(
                            "useruser",
                            "Everytime :D",
                            "https://media.wwltv.com/assets/WTLV/images/5c881363-09ae-4e8f-be14-2b7a6b85f70a/5c881363-09ae-4e8f-be14-2b7a6b85f70a_750x422.jpg"
                    ),
                    FeedItem(
                            "alafs",
                            "No comment",
                            "https://media.npr.org/assets/img/2015/03/03/overly_custom-39399d2cf8b6395770e3f10fd45b22ce39df70d4-s800-c85.jpg"
                    ),
                    FeedItem(
                            "goose56",
                            "That's the spirit",
                            "https://global-uploads.webflow.com/5f4dd3623430990e705ccbba/5f7f7c8e6edbbd779a48bf71_22601782810_cbe3ede5f5_o.focus-none.original.jpeg"
                    ),
                    FeedItem(
                            "lemon98",
                            "getting ready for summer",
                            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzdLSM0G41--ApMr9XSfV2fo3cscQRHLq3Eg&usqp=CAU"
                    ),
                    FeedItem(
                            "lemon96",
                            "HAHa funny3",
                            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKoRPv8qPzNk3u4RFduuEGySYN1P7DSASoIw&usqp=CAU"
                    ),
                    FeedItem(
                            "funny_guy:)",
                            "Just gorgeous <3",
                            "https://static.boredpanda.com/blog/wp-content/uploads/2016/10/worlds-most-beautiful-cats-3-57fb53b8a6127__700.jpg"
                    ),
                    FeedItem(
                            "flawss",
                            "Fluffy <333333",
                            "https://i.pinimg.com/236x/b8/c4/0b/b8c40bc51e6b01366992a9ada62b0036.jpg"
                    ),
                    FeedItem(
                            "catycaty",
                            "Eat Sleep Paw - repeat <3",
                            "https://i.pinimg.com/originals/31/6e/5f/316e5f0237fc31389f2f62fb83887c57.jpg"
                    ),
                    FeedItem(
                            "catycaty",
                            "Choose your paw",
                            "https://thumbs.dreamstime.com/b/cat-paws-cute-hand-drawn-dog-kitten-claws-cartoon-funny-kitty-puppy-animal-foot-vector-isolated-sketch-set-drawings-166724888.jpg"
                    ),
                    FeedItem(
                            "user2",
                            "Oooooooops",
                            "https://media1.popsugar-assets.com/files/thumbor/YW5HqqfTlaHdYBG0F4DWW68lN78/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2020/05/22/880/n/1922153/a01e93b95ec8311f375e90.74475107_/i/Funny-Beauty-Memes.jpg"
                    ),
                    FeedItem(
                            "maxxxx",
                            "awkward",
                            "https://media1.popsugar-assets.com/files/thumbor/YW5HqqfTlaHdYBG0F4DWW68lN78/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2020/05/22/880/n/1922153/a01e93b95ec8311f375e90.74475107_/i/Funny-Beauty-Memes.jpg"
                    ),
                    FeedItem(
                            "catycaty",
                            "looking for a poncho :D",
                            "https://images.squarespace-cdn.com/content/v1/573cab48a3360c65142b4bf6/1561474431058-OANCM9U35P6HKIKJT4TD/ke17ZwdGBToddI8pDm48kJK4Mm1kch8SFO9ZNkN1NT97gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QHyNOqBUUEtDDsRWrJLTmN9YSRtfoTLg6dUq-6F17A0FFZK5fArcnK1IqGweyunyWChwIwkIJ_P7MaZif-uMs/Untitled+design-12.png"
                    ),
                    FeedItem(
                            "louisMat",
                            "Adorable animals",
                            "https://i.pinimg.com/originals/b5/2d/f2/b52df2f76467cda64d3e16a288f52b8c.jpg"
                    ),
                    FeedItem(
                            "goose56",
                            "Hello",
                            "https://www.dartagnan.com/on/demandware.static/-/Sites-dartagnan-Library/default/dwff492747/images/content/goose-facts-and-cooking.jpg"
                    ),
                    FeedItem(
                            "goose56",
                            "It's me",
                            "https://upload.wikimedia.org/wikipedia/commons/3/39/Domestic_Goose.jpg"
                    ),
                    FeedItem(
                            "goose56",
                            "HAHa funny2",
                            "https://images.unsplash.com/photo-1612240498936-65f5101365d2?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
                    ),
                    FeedItem(
                            "frenchGuy",
                            "Informative",
                            "https://images.prismic.io/allplants-cms-prod/4d41a068-003a-45f5-8f54-539c4486d914_202006_Croissants-resize.jpg?auto=compress,format"
                    ),
                    FeedItem(
                            "englishman_in_newyork",
                            "beautiful",
                            "https://images.unsplash.com/photo-1505673542670-a5e3ff5b14a3?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
                    ),
                    FeedItem(
                            "Joe Cocker",
                            "<3",
                            "https://images.unsplash.com/photo-1612240498936-65f5101365d2?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
                    ),
                    FeedItem(
                            "your_santa",
                            "I love it",
                            "https://images.unsplash.com/photo-1614092859936-a1ec05a607e4?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80"
                    ),
                    FeedItem(
                            "maxxx",
                            "HAHa funny",
                            "https://static.mommypoppins.com/styles/image620x420/s3/school_meme_3_0.jpg"
                    ),
                    FeedItem(
                            "MiliMenta",
                            "Everytime :D",
                            "https://i.chzbgr.com/full/4035845/hB03D02F6/funny-memes-the-best-of-em"
                    ),
                    FeedItem(
                            "MiliMenta",
                            "HAHa funny3",
                            "https://images.unsplash.com/photo-1614092859936-a1ec05a607e4?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80"
                    ),
                    FeedItem(
                            "MiliMenta",
                            "HAHa funny",
                            "https://images.unsplash.com/photo-1505673542670-a5e3ff5b14a3?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
                    ),
                    FeedItem(
                            "MiliMenta",
                            "HAHa funny2",
                            "https://images.unsplash.com/photo-1612240498936-65f5101365d2?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
                    ),
                    FeedItem(
                            "serial111",
                            "HAHa funny3",
                            "https://images.unsplash.com/photo-1614092859936-a1ec05a607e4?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80"
                    ),
                    FeedItem(
                            "digital89",
                            "HAHa funny",
                            "https://images.unsplash.com/photo-1505673542670-a5e3ff5b14a3?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
                    ),
                    FeedItem(
                            "digital89",
                            "HAHa funny2",
                            "https://images.unsplash.com/photo-1612240498936-65f5101365d2?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
                    ),
                    FeedItem(
                            "serial111",
                            "HAHa funny3",
                            "https://images.unsplash.com/photo-1614092859936-a1ec05a607e4?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80"
                    )
            )
        }

        recyclerListExampleButton.setOnClickListener {
            val intent = Intent(this, FeedActivity::class.java)
            intent.putExtra("posts", posts);
            startActivity(intent)
        }
    }
}

