package com.eokman.simplebgg.data.source.remote.model

import org.junit.Test
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister
import java.io.StringReader


class BoardGameTest {

    @Test
    fun unmarshalTest() {
        testXml = testXml.replace("&ldquo;", "\"")
        testXml = testXml.replace("&rdquo;", "\"")
        testXml = testXml.replace("&rsquo;", "\'")
        val re = StringReader(testXml)
        val serializer: Serializer = Persister()
        val boardGame: BoardGameXML = serializer.read(BoardGameXML::class.java, re)

        println("unmarshalTest")
        print("$boardGame")
    }

    @Test
    fun marshalTest() {
//        val serializer: Serializer = Persister()
//        serializer.re
        val b = BoardGameXML(id = "111", image = "urllll", minplayers = ValueAttrXML("2"), description = "s\'s\"s", yearpublished = ValueAttrXML("1986"))
//        val jaxbContext = JAXBContext.newInstance(BoardGameXML::class.java)
//        val m = jaxbContext.createMarshaller()
//        m.setAdapter(StringValueAdapter::class.java, StringValueAdapter())
        println("marshalTest")
//        m.marshal(b, System.out)
    }

    var testXml: String = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
            "<item type=\"boardgame\" id=\"174430\">\n" +
            "<thumbnail>\n" +
            "https://cf.geekdo-images.com/thumb/img/e7GyV4PaNtwmalU-EQAGecwoBSI=/fit-in/200x150/pic2437871.jpg\n" +
            "</thumbnail>\n" +
            "<image>\n" +
            "https://cf.geekdo-images.com/original/img/lDN358RgcYvQfYYN6Oy2TXpifyM=/0x0/pic2437871.jpg\n" +
            "</image>\n" +
            "<name type=\"primary\" sortindex=\"1\" value=\"Gloomhaven\"/>\n" +
            "<name type=\"alternate\" sortindex=\"1\" value=\"Gloomhaven, aventures à Havrenuit\"/>\n" +
            "<name type=\"alternate\" sortindex=\"1\" value=\"Gloomhaven. Мрачная Гавань\"/>\n" +
            "<name type=\"alternate\" sortindex=\"1\" value=\"Homályrév\"/>\n" +
            "<name type=\"alternate\" sortindex=\"1\" value=\"幽港迷城\"/>\n" +
            "<name type=\"alternate\" sortindex=\"1\" value=\"글룸헤이븐\"/>\n" +
            "<description>\n" +
            "Gloomhaven is a game of Euro-inspired tactical combat in a persistent world of shifting motives. Players will take on the role of a wandering adventurer with their own special set of skills and their own reasons for traveling to this dark corner of the world. Players must work together out of necessity to clear out menacing dungeons and forgotten ruins. In the process, they will enhance their abilities with experience and loot, discover new locations to explore and plunder, and expand an ever-branching story fueled by the decisions they make.&#10;&#10;This is a game with a persistent and changing world that is ideally played over many game sessions. After a scenario, players will make decisions on what to do, which will determine how the story continues, kind of like a &ldquo;Choose Your Own Adventure&rdquo; book. Playing through a scenario is a cooperative affair where players will fight against automated monsters using an innovative card system to determine the order of play and what a player does on their turn.&#10;&#10;Each turn, a player chooses two cards to play out of their hand. The number on the top card determines their initiative for the round. Each card also has a top and bottom power, and when it is a player&rsquo;s turn in the initiative order, they determine whether to use the top power of one card and the bottom power of the other, or vice-versa. Players must be careful, though, because over time they will permanently lose cards from their hands. If they take too long to clear a dungeon, they may end up exhausted and be forced to retreat.&#10;&#10;\n" +
            "</description>\n" +
            "<yearpublished value=\"2017\"/>\n" +
            "<minplayers value=\"1\"/>\n" +
            "<maxplayers value=\"4\"/>\n" +
            "<poll name=\"suggested_numplayers\" title=\"User Suggested Number of Players\" totalvotes=\"922\">\n" +
            "<results numplayers=\"1\">\n" +
            "<result value=\"Best\" numvotes=\"103\"/>\n" +
            "<result value=\"Recommended\" numvotes=\"389\"/>\n" +
            "<result value=\"Not Recommended\" numvotes=\"197\"/>\n" +
            "</results>\n" +
            "<results numplayers=\"2\">\n" +
            "<result value=\"Best\" numvotes=\"218\"/>\n" +
            "<result value=\"Recommended\" numvotes=\"498\"/>\n" +
            "<result value=\"Not Recommended\" numvotes=\"52\"/>\n" +
            "</results>\n" +
            "<results numplayers=\"3\">\n" +
            "<result value=\"Best\" numvotes=\"448\"/>\n" +
            "<result value=\"Recommended\" numvotes=\"306\"/>\n" +
            "<result value=\"Not Recommended\" numvotes=\"23\"/>\n" +
            "</results>\n" +
            "<results numplayers=\"4\">\n" +
            "<result value=\"Best\" numvotes=\"290\"/>\n" +
            "<result value=\"Recommended\" numvotes=\"359\"/>\n" +
            "<result value=\"Not Recommended\" numvotes=\"97\"/>\n" +
            "</results>\n" +
            "<results numplayers=\"4+\">\n" +
            "<result value=\"Best\" numvotes=\"3\"/>\n" +
            "<result value=\"Recommended\" numvotes=\"34\"/>\n" +
            "<result value=\"Not Recommended\" numvotes=\"499\"/>\n" +
            "</results>\n" +
            "</poll>\n" +
            "<playingtime value=\"120\"/>\n" +
            "<minplaytime value=\"60\"/>\n" +
            "<maxplaytime value=\"120\"/>\n" +
            "<minage value=\"12\"/>\n" +
            "<poll name=\"suggested_playerage\" title=\"User Suggested Player Age\" totalvotes=\"217\">\n" +
            "<results>\n" +
            "<result value=\"2\" numvotes=\"4\"/>\n" +
            "<result value=\"3\" numvotes=\"0\"/>\n" +
            "<result value=\"4\" numvotes=\"0\"/>\n" +
            "<result value=\"5\" numvotes=\"0\"/>\n" +
            "<result value=\"6\" numvotes=\"0\"/>\n" +
            "<result value=\"8\" numvotes=\"4\"/>\n" +
            "<result value=\"10\" numvotes=\"36\"/>\n" +
            "<result value=\"12\" numvotes=\"59\"/>\n" +
            "<result value=\"14\" numvotes=\"97\"/>\n" +
            "<result value=\"16\" numvotes=\"12\"/>\n" +
            "<result value=\"18\" numvotes=\"2\"/>\n" +
            "<result value=\"21 and up\" numvotes=\"3\"/>\n" +
            "</results>\n" +
            "</poll>\n" +
            "<poll name=\"language_dependence\" title=\"Language Dependence\" totalvotes=\"43\">\n" +
            "<results>\n" +
            "<result level=\"1\" value=\"No necessary in-game text\" numvotes=\"1\"/>\n" +
            "<result level=\"2\" value=\"Some necessary text - easily memorized or small crib sheet\" numvotes=\"0\"/>\n" +
            "<result level=\"3\" value=\"Moderate in-game text - needs crib sheet or paste ups\" numvotes=\"2\"/>\n" +
            "<result level=\"4\" value=\"Extensive use of text - massive conversion needed to be playable\" numvotes=\"31\"/>\n" +
            "<result level=\"5\" value=\"Unplayable in another language\" numvotes=\"9\"/>\n" +
            "</results>\n" +
            "</poll>\n" +
            "<link type=\"boardgamecategory\" id=\"1022\" value=\"Adventure\"/>\n" +
            "<link type=\"boardgamecategory\" id=\"1020\" value=\"Exploration\"/>\n" +
            "<link type=\"boardgamecategory\" id=\"1010\" value=\"Fantasy\"/>\n" +
            "<link type=\"boardgamecategory\" id=\"1046\" value=\"Fighting\"/>\n" +
            "<link type=\"boardgamecategory\" id=\"1047\" value=\"Miniatures\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2839\" value=\"Action Retrieval\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2018\" value=\"Campaign / Battle Card Driven\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2893\" value=\"Communication Limits\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2023\" value=\"Cooperative Game\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2664\" value=\"Deck, Bag, and Pool Building\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2676\" value=\"Grid Movement\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2040\" value=\"Hand Management\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2824\" value=\"Legacy Game\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2011\" value=\"Modular Board\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2846\" value=\"Once-Per-Game Abilities\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2028\" value=\"Role Playing\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2822\" value=\"Scenario / Mission / Campaign Game\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2020\" value=\"Simultaneous Action Selection\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2819\" value=\"Solo / Solitaire Game\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2027\" value=\"Storytelling\"/>\n" +
            "<link type=\"boardgamemechanic\" id=\"2015\" value=\"Variable Player Powers\"/>\n" +
            "<link type=\"boardgamefamily\" id=\"24281\" value=\"Campaign Games\"/>\n" +
            "<link type=\"boardgamefamily\" id=\"25158\" value=\"Components: Miniatures\"/>\n" +
            "<link type=\"boardgamefamily\" id=\"8374\" value=\"Crowdfunding: Kickstarter\"/>\n" +
            "<link type=\"boardgamefamily\" id=\"59218\" value=\"Dungeon Crawler\"/>\n" +
            "<link type=\"boardgamefamily\" id=\"45610\" value=\"Gloomhaven Universe\"/>\n" +
            "<link type=\"boardgamefamily\" id=\"25404\" value=\"Legacy\"/>\n" +
            "<link type=\"boardgamefamily\" id=\"5666\" value=\"Solitaire Games\"/>\n" +
            "<link type=\"boardgameexpansion\" id=\"250337\" value=\"Gloomhaven: Forgotten Circles\"/>\n" +
            "<link type=\"boardgameexpansion\" id=\"298195\" value=\"Gloomhaven: Return of the Lost Cabal\"/>\n" +
            "<link type=\"boardgameexpansion\" id=\"297586\" value=\"Gloomhaven: Secrets of the Lost Cabal\"/>\n" +
            "<link type=\"boardgameexpansion\" id=\"226868\" value=\"Gloomhaven: Solo Scenarios\"/>\n" +
            "<link type=\"boardgameexpansion\" id=\"231934\" value=\"Gloomhaven: The End of the World (Promo Scenario)\"/>\n" +
            "<link type=\"boardgameexpansion\" id=\"300402\" value=\"Gloomhaven: The Lucky Meeple (Promo Scenario)\"/>\n" +
            "<link type=\"boardgameintegration\" id=\"295770\" value=\"Frosthaven\"/>\n" +
            "<link type=\"boardgameintegration\" id=\"291457\" value=\"Gloomhaven: Jaws of the Lion\"/>\n" +
            "<link type=\"boardgamedesigner\" id=\"69802\" value=\"Isaac Childres\"/>\n" +
            "<link type=\"boardgameartist\" id=\"77084\" value=\"Alexandr Elichev\"/>\n" +
            "<link type=\"boardgameartist\" id=\"78961\" value=\"Josh T. McDowell\"/>\n" +
            "<link type=\"boardgameartist\" id=\"84269\" value=\"Alvaro Nebot\"/>\n" +
            "<link type=\"boardgamepublisher\" id=\"27425\" value=\"Cephalofair Games\"/>\n" +
            "<link type=\"boardgamepublisher\" id=\"4304\" value=\"Albi\"/>\n" +
            "<link type=\"boardgamepublisher\" id=\"157\" value=\"Asmodee\"/>\n" +
            "<link type=\"boardgamepublisher\" id=\"22380\" value=\"Feuerland Spiele\"/>\n" +
            "<link type=\"boardgamepublisher\" id=\"15605\" value=\"Galápagos Jogos\"/>\n" +
            "<link type=\"boardgamepublisher\" id=\"40478\" value=\"Games Warehouse\"/>\n" +
            "<link type=\"boardgamepublisher\" id=\"8820\" value=\"Gém Klub Kft.\"/>\n" +
            "<link type=\"boardgamepublisher\" id=\"18852\" value=\"Hobby World\"/>\n" +
            "<link type=\"boardgamepublisher\" id=\"8291\" value=\"Korea Boardgames co., Ltd.\"/>\n" +
            "<link type=\"boardgamepublisher\" id=\"23756\" value=\"MYBG Co., Ltd.\"/>\n" +
            "</item>\n"
}