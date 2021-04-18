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
	"encoding/hex"
	"encoding/xml"
	"fmt"
	"github.com/apache/plc4x/plc4go/internal/plc4go/spi/utils"
	"github.com/pkg/errors"
	"io"
	"strings"
)

// Code generated by build-utils. DO NOT EDIT.

// Constant values.
const BACnetConfirmedServiceRequestReadProperty_OBJECTIDENTIFIERHEADER uint8 = 0x0C
const BACnetConfirmedServiceRequestReadProperty_PROPERTYIDENTIFIERHEADER uint8 = 0x03

// The data-structure of this message
type BACnetConfirmedServiceRequestReadProperty struct {
	ObjectType               uint16
	ObjectInstanceNumber     uint32
	PropertyIdentifierLength uint8
	PropertyIdentifier       []int8
	Parent                   *BACnetConfirmedServiceRequest
}

// The corresponding interface
type IBACnetConfirmedServiceRequestReadProperty interface {
	LengthInBytes() uint16
	LengthInBits() uint16
	Serialize(io utils.WriteBuffer) error
	xml.Marshaler
	xml.Unmarshaler
}

///////////////////////////////////////////////////////////
// Accessors for discriminator values.
///////////////////////////////////////////////////////////
func (m *BACnetConfirmedServiceRequestReadProperty) ServiceChoice() uint8 {
	return 0x0C
}

func (m *BACnetConfirmedServiceRequestReadProperty) InitializeParent(parent *BACnetConfirmedServiceRequest) {
}

func NewBACnetConfirmedServiceRequestReadProperty(objectType uint16, objectInstanceNumber uint32, propertyIdentifierLength uint8, propertyIdentifier []int8) *BACnetConfirmedServiceRequest {
	child := &BACnetConfirmedServiceRequestReadProperty{
		ObjectType:               objectType,
		ObjectInstanceNumber:     objectInstanceNumber,
		PropertyIdentifierLength: propertyIdentifierLength,
		PropertyIdentifier:       propertyIdentifier,
		Parent:                   NewBACnetConfirmedServiceRequest(),
	}
	child.Parent.Child = child
	return child.Parent
}

func CastBACnetConfirmedServiceRequestReadProperty(structType interface{}) *BACnetConfirmedServiceRequestReadProperty {
	castFunc := func(typ interface{}) *BACnetConfirmedServiceRequestReadProperty {
		if casted, ok := typ.(BACnetConfirmedServiceRequestReadProperty); ok {
			return &casted
		}
		if casted, ok := typ.(*BACnetConfirmedServiceRequestReadProperty); ok {
			return casted
		}
		if casted, ok := typ.(BACnetConfirmedServiceRequest); ok {
			return CastBACnetConfirmedServiceRequestReadProperty(casted.Child)
		}
		if casted, ok := typ.(*BACnetConfirmedServiceRequest); ok {
			return CastBACnetConfirmedServiceRequestReadProperty(casted.Child)
		}
		return nil
	}
	return castFunc(structType)
}

func (m *BACnetConfirmedServiceRequestReadProperty) GetTypeName() string {
	return "BACnetConfirmedServiceRequestReadProperty"
}

func (m *BACnetConfirmedServiceRequestReadProperty) LengthInBits() uint16 {
	return m.LengthInBitsConditional(false)
}

func (m *BACnetConfirmedServiceRequestReadProperty) LengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(m.Parent.ParentLengthInBits())

	// Const Field (objectIdentifierHeader)
	lengthInBits += 8

	// Simple field (objectType)
	lengthInBits += 10

	// Simple field (objectInstanceNumber)
	lengthInBits += 22

	// Const Field (propertyIdentifierHeader)
	lengthInBits += 5

	// Simple field (propertyIdentifierLength)
	lengthInBits += 3

	// Array field
	if len(m.PropertyIdentifier) > 0 {
		lengthInBits += 8 * uint16(len(m.PropertyIdentifier))
	}

	return lengthInBits
}

func (m *BACnetConfirmedServiceRequestReadProperty) LengthInBytes() uint16 {
	return m.LengthInBits() / 8
}

func BACnetConfirmedServiceRequestReadPropertyParse(io *utils.ReadBuffer) (*BACnetConfirmedServiceRequest, error) {

	// Const Field (objectIdentifierHeader)
	objectIdentifierHeader, _objectIdentifierHeaderErr := io.ReadUint8(8)
	if _objectIdentifierHeaderErr != nil {
		return nil, errors.Wrap(_objectIdentifierHeaderErr, "Error parsing 'objectIdentifierHeader' field")
	}
	if objectIdentifierHeader != BACnetConfirmedServiceRequestReadProperty_OBJECTIDENTIFIERHEADER {
		return nil, errors.New("Expected constant value " + fmt.Sprintf("%d", BACnetConfirmedServiceRequestReadProperty_OBJECTIDENTIFIERHEADER) + " but got " + fmt.Sprintf("%d", objectIdentifierHeader))
	}

	// Simple Field (objectType)
	objectType, _objectTypeErr := io.ReadUint16(10)
	if _objectTypeErr != nil {
		return nil, errors.Wrap(_objectTypeErr, "Error parsing 'objectType' field")
	}

	// Simple Field (objectInstanceNumber)
	objectInstanceNumber, _objectInstanceNumberErr := io.ReadUint32(22)
	if _objectInstanceNumberErr != nil {
		return nil, errors.Wrap(_objectInstanceNumberErr, "Error parsing 'objectInstanceNumber' field")
	}

	// Const Field (propertyIdentifierHeader)
	propertyIdentifierHeader, _propertyIdentifierHeaderErr := io.ReadUint8(5)
	if _propertyIdentifierHeaderErr != nil {
		return nil, errors.Wrap(_propertyIdentifierHeaderErr, "Error parsing 'propertyIdentifierHeader' field")
	}
	if propertyIdentifierHeader != BACnetConfirmedServiceRequestReadProperty_PROPERTYIDENTIFIERHEADER {
		return nil, errors.New("Expected constant value " + fmt.Sprintf("%d", BACnetConfirmedServiceRequestReadProperty_PROPERTYIDENTIFIERHEADER) + " but got " + fmt.Sprintf("%d", propertyIdentifierHeader))
	}

	// Simple Field (propertyIdentifierLength)
	propertyIdentifierLength, _propertyIdentifierLengthErr := io.ReadUint8(3)
	if _propertyIdentifierLengthErr != nil {
		return nil, errors.Wrap(_propertyIdentifierLengthErr, "Error parsing 'propertyIdentifierLength' field")
	}

	// Array field (propertyIdentifier)
	// Count array
	propertyIdentifier := make([]int8, propertyIdentifierLength)
	for curItem := uint16(0); curItem < uint16(propertyIdentifierLength); curItem++ {
		_item, _err := io.ReadInt8(8)
		if _err != nil {
			return nil, errors.Wrap(_err, "Error parsing 'propertyIdentifier' field")
		}
		propertyIdentifier[curItem] = _item
	}

	// Create a partially initialized instance
	_child := &BACnetConfirmedServiceRequestReadProperty{
		ObjectType:               objectType,
		ObjectInstanceNumber:     objectInstanceNumber,
		PropertyIdentifierLength: propertyIdentifierLength,
		PropertyIdentifier:       propertyIdentifier,
		Parent:                   &BACnetConfirmedServiceRequest{},
	}
	_child.Parent.Child = _child
	return _child.Parent, nil
}

func (m *BACnetConfirmedServiceRequestReadProperty) Serialize(io utils.WriteBuffer) error {
	ser := func() error {

		// Const Field (objectIdentifierHeader)
		_objectIdentifierHeaderErr := io.WriteUint8(8, 0x0C)
		if _objectIdentifierHeaderErr != nil {
			return errors.Wrap(_objectIdentifierHeaderErr, "Error serializing 'objectIdentifierHeader' field")
		}

		// Simple Field (objectType)
		objectType := uint16(m.ObjectType)
		_objectTypeErr := io.WriteUint16(10, (objectType))
		if _objectTypeErr != nil {
			return errors.Wrap(_objectTypeErr, "Error serializing 'objectType' field")
		}

		// Simple Field (objectInstanceNumber)
		objectInstanceNumber := uint32(m.ObjectInstanceNumber)
		_objectInstanceNumberErr := io.WriteUint32(22, (objectInstanceNumber))
		if _objectInstanceNumberErr != nil {
			return errors.Wrap(_objectInstanceNumberErr, "Error serializing 'objectInstanceNumber' field")
		}

		// Const Field (propertyIdentifierHeader)
		_propertyIdentifierHeaderErr := io.WriteUint8(5, 0x03)
		if _propertyIdentifierHeaderErr != nil {
			return errors.Wrap(_propertyIdentifierHeaderErr, "Error serializing 'propertyIdentifierHeader' field")
		}

		// Simple Field (propertyIdentifierLength)
		propertyIdentifierLength := uint8(m.PropertyIdentifierLength)
		_propertyIdentifierLengthErr := io.WriteUint8(3, (propertyIdentifierLength))
		if _propertyIdentifierLengthErr != nil {
			return errors.Wrap(_propertyIdentifierLengthErr, "Error serializing 'propertyIdentifierLength' field")
		}

		// Array Field (propertyIdentifier)
		if m.PropertyIdentifier != nil {
			for _, _element := range m.PropertyIdentifier {
				_elementErr := io.WriteInt8(8, _element)
				if _elementErr != nil {
					return errors.Wrap(_elementErr, "Error serializing 'propertyIdentifier' field")
				}
			}
		}

		return nil
	}
	return m.Parent.SerializeParent(io, m, ser)
}

func (m *BACnetConfirmedServiceRequestReadProperty) UnmarshalXML(d *xml.Decoder, start xml.StartElement) error {
	var token xml.Token
	var err error
	foundContent := false
	token = start
	for {
		switch token.(type) {
		case xml.StartElement:
			foundContent = true
			tok := token.(xml.StartElement)
			switch tok.Name.Local {
			case "objectType":
				var data uint16
				if err := d.DecodeElement(&data, &tok); err != nil {
					return err
				}
				m.ObjectType = data
			case "objectInstanceNumber":
				var data uint32
				if err := d.DecodeElement(&data, &tok); err != nil {
					return err
				}
				m.ObjectInstanceNumber = data
			case "propertyIdentifierLength":
				var data uint8
				if err := d.DecodeElement(&data, &tok); err != nil {
					return err
				}
				m.PropertyIdentifierLength = data
			case "propertyIdentifier":
				var _encoded string
				if err := d.DecodeElement(&_encoded, &tok); err != nil {
					return err
				}
				_decoded, err := hex.DecodeString(_encoded)
				_len := len(_decoded)
				if err != nil {
					return err
				}
				m.PropertyIdentifier = utils.ByteArrayToInt8Array(_decoded[0:_len])
			}
		}
		token, err = d.Token()
		if err != nil {
			if err == io.EOF && foundContent {
				return nil
			}
			return err
		}
	}
}

func (m *BACnetConfirmedServiceRequestReadProperty) MarshalXML(e *xml.Encoder, start xml.StartElement) error {
	if err := e.EncodeElement(m.ObjectType, xml.StartElement{Name: xml.Name{Local: "objectType"}}); err != nil {
		return err
	}
	if err := e.EncodeElement(m.ObjectInstanceNumber, xml.StartElement{Name: xml.Name{Local: "objectInstanceNumber"}}); err != nil {
		return err
	}
	if err := e.EncodeElement(m.PropertyIdentifierLength, xml.StartElement{Name: xml.Name{Local: "propertyIdentifierLength"}}); err != nil {
		return err
	}
	_encodedPropertyIdentifier := hex.EncodeToString(utils.Int8ArrayToByteArray(m.PropertyIdentifier))
	_encodedPropertyIdentifier = strings.ToUpper(_encodedPropertyIdentifier)
	if err := e.EncodeElement(_encodedPropertyIdentifier, xml.StartElement{Name: xml.Name{Local: "propertyIdentifier"}}); err != nil {
		return err
	}
	return nil
}

func (m BACnetConfirmedServiceRequestReadProperty) String() string {
	return string(m.Box("", 120))
}

func (m BACnetConfirmedServiceRequestReadProperty) Box(name string, width int) utils.AsciiBox {
	boxName := "BACnetConfirmedServiceRequestReadProperty"
	if name != "" {
		boxName += "/" + name
	}
	childBoxer := func() []utils.AsciiBox {
		boxes := make([]utils.AsciiBox, 0)
		// Const Field (objectIdentifierHeader)
		boxes = append(boxes, utils.BoxAnything("ObjectIdentifierHeader", uint8(0x0C), -1))
		// Simple field (case simple)
		// uint16 can be boxed as anything with the least amount of space
		boxes = append(boxes, utils.BoxAnything("ObjectType", m.ObjectType, -1))
		// Simple field (case simple)
		// uint32 can be boxed as anything with the least amount of space
		boxes = append(boxes, utils.BoxAnything("ObjectInstanceNumber", m.ObjectInstanceNumber, -1))
		// Const Field (propertyIdentifierHeader)
		boxes = append(boxes, utils.BoxAnything("PropertyIdentifierHeader", uint8(0x03), -1))
		// Simple field (case simple)
		// uint8 can be boxed as anything with the least amount of space
		boxes = append(boxes, utils.BoxAnything("PropertyIdentifierLength", m.PropertyIdentifierLength, -1))
		// Array Field (propertyIdentifier)
		if m.PropertyIdentifier != nil {
			// Simple array base type int8 will be rendered one by one
			arrayBoxes := make([]utils.AsciiBox, 0)
			for _, _element := range m.PropertyIdentifier {
				arrayBoxes = append(arrayBoxes, utils.BoxAnything("", _element, width-2))
			}
			boxes = append(boxes, utils.BoxBox("PropertyIdentifier", utils.AlignBoxes(arrayBoxes, width-4), 0))
		}
		return boxes
	}
	return m.Parent.BoxParent(boxName, width, childBoxer)
}
