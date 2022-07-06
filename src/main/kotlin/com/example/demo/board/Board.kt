package com.example.demo.board

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column
    var title: String = ""

    @Column
    @NotEmpty
    var content: String? = null
}