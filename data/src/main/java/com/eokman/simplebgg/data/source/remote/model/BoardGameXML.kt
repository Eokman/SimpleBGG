package com.eokman.simplebgg.data.source.remote.model

import com.eokman.simplebgg.data.model.BoardGame
import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "items", strict = false)
data class BoardGameXMList (
    @field:ElementList(name = "item", inline = true)
    var item: List<BoardGameXML> = mutableListOf()
)

@Root(name = "item", strict = false)
data class BoardGameXML (
    @field:Attribute(name = "id")
    var id: String = "",
    @field:ElementList(name = "name", inline = true)
    var name: List<BoardGameName> = mutableListOf(),
    @field:Element
    var image: String = "",
    @field:Element
    var thumbnail: String = "",
    @field:Element
    var yearpublished: ValueAttrXML = ValueAttrXML(),
    @field:Element
    var description: String = "",
    @field:Element
    var minplayers: ValueAttrXML = ValueAttrXML(),
    @field:Element
    var maxplayers: ValueAttrXML = ValueAttrXML(),
    @field:Element
    var playingtime: ValueAttrXML = ValueAttrXML(),
    @field:Element
    var minage: ValueAttrXML = ValueAttrXML()
) {
    fun toModel(): BoardGame = BoardGame(id = id,
    name = name[0].value,
    imageUrl = image,
    thumbnail = thumbnail,
    yearpublished = yearpublished.value.toInt(),
    description = description,
    minplayers = minplayers.value.toInt(),
    maxplayers = maxplayers.value.toInt(),
    playingtime = playingtime.value.toInt(),
    minage = minage.value.toInt(),
    rank = 0)
}

@Root(name = "name", strict = false)
data class BoardGameName (
    @field:Attribute
    var type: String = "",
    @field:Attribute
    var value: String = ""
)

@Root(name = "items", strict = false)
data class HotBoardGameXMList (
    @field:ElementList(name = "item", inline = true)
    var item: List<HotBoardGameXml> = mutableListOf()
)

@Root(name= "item")
data class HotBoardGameXml(
    @field:Attribute(name = "id")
    var id: String = "",
    @field:Attribute(name = "rank")
    var rank: String = "",
    @field:Element
    var thumbnail: ValueAttrXML = ValueAttrXML(),
    @field:Element
    var name: ValueAttrXML = ValueAttrXML(),
    @field:Element
    var yearpublished: ValueAttrXML = ValueAttrXML()
) {
    fun toModel(): BoardGame = BoardGame(id = id,
        name = name.value,
        thumbnail = thumbnail.value,
        yearpublished = yearpublished.value.toInt(),
        rank = rank.toInt())
}

data class ValueAttrXML(@field:Attribute var value: String = "")