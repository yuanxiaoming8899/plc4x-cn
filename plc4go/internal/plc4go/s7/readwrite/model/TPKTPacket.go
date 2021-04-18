//
// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
//

package model

import (
	"encoding/xml"
	"fmt"
	"github.com/apache/plc4x/plc4go/internal/plc4go/spi/utils"
	"github.com/pkg/errors"
	"github.com/rs/zerolog/log"
	"io"
)

// Code generated by build-utils. DO NOT EDIT.

// Constant values.
const TPKTPacket_PROTOCOLID uint8 = 0x03

// The data-structure of this message
type TPKTPacket struct {
	Payload *COTPPacket
}

// The corresponding interface
type ITPKTPacket interface {
	LengthInBytes() uint16
	LengthInBits() uint16
	Serialize(io utils.WriteBuffer) error
	xml.Marshaler
	xml.Unmarshaler
}

func NewTPKTPacket(payload *COTPPacket) *TPKTPacket {
	return &TPKTPacket{Payload: payload}
}

func CastTPKTPacket(structType interface{}) *TPKTPacket {
	castFunc := func(typ interface{}) *TPKTPacket {
		if casted, ok := typ.(TPKTPacket); ok {
			return &casted
		}
		if casted, ok := typ.(*TPKTPacket); ok {
			return casted
		}
		return nil
	}
	return castFunc(structType)
}

func (m *TPKTPacket) GetTypeName() string {
	return "TPKTPacket"
}

func (m *TPKTPacket) LengthInBits() uint16 {
	return m.LengthInBitsConditional(false)
}

func (m *TPKTPacket) LengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(0)

	// Const Field (protocolId)
	lengthInBits += 8

	// Reserved Field (reserved)
	lengthInBits += 8

	// Implicit Field (len)
	lengthInBits += 16

	// Simple field (payload)
	lengthInBits += m.Payload.LengthInBits()

	return lengthInBits
}

func (m *TPKTPacket) LengthInBytes() uint16 {
	return m.LengthInBits() / 8
}

func TPKTPacketParse(io *utils.ReadBuffer) (*TPKTPacket, error) {

	// Const Field (protocolId)
	protocolId, _protocolIdErr := io.ReadUint8(8)
	if _protocolIdErr != nil {
		return nil, errors.Wrap(_protocolIdErr, "Error parsing 'protocolId' field")
	}
	if protocolId != TPKTPacket_PROTOCOLID {
		return nil, errors.New("Expected constant value " + fmt.Sprintf("%d", TPKTPacket_PROTOCOLID) + " but got " + fmt.Sprintf("%d", protocolId))
	}

	// Reserved Field (Compartmentalized so the "reserved" variable can't leak)
	{
		reserved, _err := io.ReadUint8(8)
		if _err != nil {
			return nil, errors.Wrap(_err, "Error parsing 'reserved' field")
		}
		if reserved != uint8(0x00) {
			log.Info().Fields(map[string]interface{}{
				"expected value": uint8(0x00),
				"got value":      reserved,
			}).Msg("Got unexpected response.")
		}
	}

	// Implicit Field (len) (Used for parsing, but it's value is not stored as it's implicitly given by the objects content)
	len, _lenErr := io.ReadUint16(16)
	_ = len
	if _lenErr != nil {
		return nil, errors.Wrap(_lenErr, "Error parsing 'len' field")
	}

	// Simple Field (payload)
	payload, _payloadErr := COTPPacketParse(io, uint16(len)-uint16(uint16(4)))
	if _payloadErr != nil {
		return nil, errors.Wrap(_payloadErr, "Error parsing 'payload' field")
	}

	// Create the instance
	return NewTPKTPacket(payload), nil
}

func (m *TPKTPacket) Serialize(io utils.WriteBuffer) error {

	// Const Field (protocolId)
	_protocolIdErr := io.WriteUint8(8, 0x03)
	if _protocolIdErr != nil {
		return errors.Wrap(_protocolIdErr, "Error serializing 'protocolId' field")
	}

	// Reserved Field (reserved)
	{
		_err := io.WriteUint8(8, uint8(0x00))
		if _err != nil {
			return errors.Wrap(_err, "Error serializing 'reserved' field")
		}
	}

	// Implicit Field (len) (Used for parsing, but it's value is not stored as it's implicitly given by the objects content)
	len := uint16(uint16(m.Payload.LengthInBytes()) + uint16(uint16(4)))
	_lenErr := io.WriteUint16(16, (len))
	if _lenErr != nil {
		return errors.Wrap(_lenErr, "Error serializing 'len' field")
	}

	// Simple Field (payload)
	_payloadErr := m.Payload.Serialize(io)
	if _payloadErr != nil {
		return errors.Wrap(_payloadErr, "Error serializing 'payload' field")
	}

	return nil
}

func (m *TPKTPacket) UnmarshalXML(d *xml.Decoder, start xml.StartElement) error {
	var token xml.Token
	var err error
	foundContent := false
	for {
		token, err = d.Token()
		if err != nil {
			if err == io.EOF && foundContent {
				return nil
			}
			return err
		}
		switch token.(type) {
		case xml.StartElement:
			foundContent = true
			tok := token.(xml.StartElement)
			switch tok.Name.Local {
			case "payload":
				var dt *COTPPacket
				if err := d.DecodeElement(&dt, &tok); err != nil {
					if err == io.EOF {
						continue
					}
					return err
				}
				m.Payload = dt
			}
		}
	}
}

func (m *TPKTPacket) MarshalXML(e *xml.Encoder, start xml.StartElement) error {
	className := "org.apache.plc4x.java.s7.readwrite.TPKTPacket"
	if err := e.EncodeToken(xml.StartElement{Name: start.Name, Attr: []xml.Attr{
		{Name: xml.Name{Local: "className"}, Value: className},
	}}); err != nil {
		return err
	}
	if err := e.EncodeElement(m.Payload, xml.StartElement{Name: xml.Name{Local: "payload"}}); err != nil {
		return err
	}
	if err := e.EncodeToken(xml.EndElement{Name: start.Name}); err != nil {
		return err
	}
	return nil
}

func (m TPKTPacket) String() string {
	return string(m.Box("", 120))
}

func (m TPKTPacket) Box(name string, width int) utils.AsciiBox {
	boxName := "TPKTPacket"
	if name != "" {
		boxName += "/" + name
	}
	boxes := make([]utils.AsciiBox, 0)
	// Const Field (protocolId)
	boxes = append(boxes, utils.BoxAnything("ProtocolId", uint8(0x03), -1))
	// Reserved Field (reserved)
	// reserved field can be boxed as anything with the least amount of space
	boxes = append(boxes, utils.BoxAnything("reserved", uint8(0x00), -1))
	// Implicit Field (len)
	len := uint16(uint16(m.Payload.LengthInBytes()) + uint16(uint16(4)))
	// uint16 can be boxed as anything with the least amount of space
	boxes = append(boxes, utils.BoxAnything("Len", len, -1))
	// Complex field (case complex)
	boxes = append(boxes, m.Payload.Box("payload", width-2))
	return utils.BoxBox(boxName, utils.AlignBoxes(boxes, width-2), 0)
}
